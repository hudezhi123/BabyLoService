package com.hdz.babyloservice.util;

public class Constants {

    public static final String BASE_URL = "http://192.168.2.84:8080/";

    public static final String IMG_DIR = BASE_URL + "img/";

    public static final String LOGIN = "/login";
    public static final String ANIMAL_LIST = "/animalList";

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAIL = 1;
    public static final String SUCCESS = "成功";
    public static final String FAIL = "失败";

    public static final String TB_USER = "tb_users";

    public static final String USER_ID = "userId";
    public static final String USER_NAME = "userName";
    public static final String PASSWORD = "password";
    public static final String LOGIN_STATUS = "isLogin";
    public static final String LOGIN_TIME = "latestLoginTime";

    public static final String TB_PROTOCOL = "tb_protocol";

    public static final String PROTOCOL_TYPE = "type";
    public static final String PROTOCOL_NAME = "name";
    public static final String PROTOCOL_ID = "id";
    public static final String PROTOCOL_URL = "url";
    public static final String PROTOCOL_TITLE = "title";
    public static final String PROTOCOL_AUTHOR = "author";
    public static final String PROTOCOL_CREATETIME = "createtime";

    public static final String TB_APP = "tb_app";
    public static final String APP_ID = "id";
    public static final String APP_APPID = "appId";
    public static final String APP_NAME = "appName";
    public static final String APP_TYPE = "appType";
    public static final String APP_VERSION_NAME = "versionName";
    public static final String APP_VERSION_CODE = "versionCode";
    public static final String APP_APK_URL = "apkUrl";
    public static final String APP_FORCE_STATUS = "forceStatus";
    public static final String APP_TIPS = "tips";

    public static final String TB_USER_INFO = "tb_user_info";
    public static final String TB_MESSAGE = "tb_message";

    public static final String TB_ANIMAL = "tb_animal";
    public static final String ANIMAL_ID = "id";
    public static final String ANIMAL_NAME = "animalName";
    public static final String ANIMAL_DESC = "introduce";
    public static final String ANIMAL_EN_NAME = "enName";
    public static final String ANIMAL_IMG_COUNT = "imgCount";

    public static final String TIPS_RESITER_NAME_DULPLICATE = "该用户名已经被使用！";

    public static final String TIPS_REGISTER_SUCCESS = "注册成功！";
    public static final String TIPS_REGISTER_FAIL = "注册失败！";

    public static final String TIPS_LOGIN_SUCCESS = "登录成功！";
    public static final String TIPS_LOGIN_FAIL = "登录失败！";
    public static final String TIPS_LOGIN_NO_SUCH_USER = "用户不存在！";

    public static final String TIPS_PROTOCOL_SUCCESS = "获取协议内容成功";
    public static final String TIPS_PROTOCOL_FAIL = "获取协议内容失败";

    public static final String TAG_ANIMAL = "动物";
    public static final String TIPS_ANIMAL = "获取动物列表失败！";
}
