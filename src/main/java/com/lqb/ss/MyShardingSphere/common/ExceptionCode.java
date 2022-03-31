package com.lqb.ss.MyShardingSphere.common;

public enum ExceptionCode
{
    // 内部抛错使用
    INNER_EXCEPTION(-99999999) ,
    TokenInterceptor(-500) ,

    RegisterServiceimpl(-20000) ,
//    ModuleServiceImpl(-20000) ,
//    UsersServiceImpl(-30000) ,
//    UsersController(-30001) ,
//    PermissionServiceImpl(-40000)
    ;

    private final int value;

    ExceptionCode(
            int value
    )
    {
        this.value = value;
    }

    public
    int getValue()
    {
        return value;
    }
}
