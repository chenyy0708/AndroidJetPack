# encoding = utf-8
import sys
import traceback
import requests

requests.packages.urllib3.disable_warnings()


def uploadtofir():
    # 参数检查
    paramnum = 8
    syslen = len(sys.argv)
    if syslen < paramnum:
        print("please input param")
        return
    else:
        # 基础参数
        appname = sys.argv[1]  # app名称
        apppackage = sys.argv[2]  # 唯一包名，也即是bundle_id
        appversion = sys.argv[3]  # app版本号
        appbuild = sys.argv[4]  # app build号
        apitoken = sys.argv[5]  # fir token
        apklogo = sys.argv[6]  # 等待上传的APK logo路径
        apkpath = sys.argv[7]  # 等待上传的APK路径

        # 第一步：获取fir上传凭证
        print("get fir upload certificate")
        icondict = {}  # 后面上传图标和apk需要使用的参数，这里保存下来
        binarydict = {}
        try:
            req = requests.post("http://api.fir.im/apps",
                                {'type': 'android', 'bundle_id': apppackage, 'api_token': apitoken})
            resjson = req.json()
            icondict = (resjson["cert"]["icon"])
            binarydict = (resjson["cert"]["binary"])
            print("get fir upload certificate success")

        except Exception:
            print("get fir upload certificate error")
            traceback.print_exc()

        # 第二步：上传APK
        try:
            print("uploading apk......")
            apkfile = {'file': open(apkpath, 'rb')}
            param = {"key": binarydict["key"],
                     "token": binarydict["token"],
                     "x:name": appname,
                     "x:version": appversion,
                     "x:build": appbuild}
            req = requests.post(url=binarydict["upload_url"], files=apkfile, data=param, verify=False)
        except Exception as e:
            print("upload apk error")
            traceback.print_exc()

        # 第三步：上传APK logo
        try:
            print("uploading apk......" + apklogo)
            apklogofile = {'file': open(apklogo, 'rb')}
            param = {"key": icondict["key"],
                     "token": icondict["token"]}
            req = requests.post(url=icondict["upload_url"], files=apklogofile, data=param, verify=False)
        except Exception:
            print("upload apk error")
            traceback.print_exc()

        # 第四步：获取APK最新下载地址
        queryurl = 'http://api.fir.im/apps/latest/%s?api_token=%s&type=android' % (apppackage, apitoken)
        try:
            req = requests.get(queryurl)
            update_url = (req.json()["update_url"])
            print("upload apk success, update url is " + update_url)
        except Exception:
            print("upload apk error")
            traceback.print_exc()


if __name__ == '__main__':
    uploadtofir()