# 实时公交后台代码

## Bus接口文档
> 所有的无参请求均为GET，有参请求均为POST，注意：请求参数为JSON格式

### 接口返回示例：
正确：
```$xslt
{
    "repCode": "0000",
    "repMsg": null,
    "datas": "该字段为成功后返回信息，可能是空，或对象，或数组,或提示信息"
}
```
错误：
```$xslt
{
    "repCode": "错误提示码，可以不关注，不是0000均为错误",
    "repMsg": "错误提示信息",
    "datas": null
}
```
分页返回结果：
```$xslt
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [],
    "currentPage": 1,
    "pageSize": 10,
    "totalCount": 0,
    "haveNextPage": false,
    "havePrePage": false,
    "pageCount": 0
}
```

### 接口

#### 测试接口

URL
```$xslt
    /bus/test
```
参数
```$xslt
    无
```
注释
 ```$xslt
     无
 ```
返回
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": "请求成功"
}
```
#### 登录

URL
```$xslt
    /bus/user/login
```
参数
```$xslt
    code: 微信登陆接口返回
```
注释
```$xslt
    小程序端需要先调用wx.login，获取code.
    调用该接口成功后,需要继续调用update接口,更新用户信息
```
[小程序微信登录API](https://mp.weixin.qq.com/debug/wxadoc/dev/api/api-login.html#wxloginobject)

返回
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": {
        id:"用户ID"
    }
}
```
#### 更新用户信息

URL
```$xslt
    /bus/user/update
```
参数
```$xslt
    id: 必填.login成功后服务器返回的用户ID
    nickName:非必填,微信昵称;
    avatarUrl:非必填,头像
    gender:非必填,性别1:男 2:女 3:未知
    city:非必填,城市
    province:非必填,省份
    country:非必填,国家
    language:非必填,语言,zh_CN为简体中文
```
注释
```$xslt
    五
```
返回
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": "数据更新成功"
}
```

#### 获取所有车辆

URL
```$xslt
    /bus/findAll
```
参数
```$xslt
    type: 查询车辆类型，夜班或白班
```
注释
```$xslt
    type的值可为空,或者"night",为空时查询所有白班车辆，为"night"时查询夜班车辆
```
返回
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [
         {
         "lineKey": "1", //线路ID
         "lineName": "1", //线路名称
         "regionCode": "bj" //城市编码
         },
         {
             "lineKey": "2",
             "lineName": "2",
             "regionCode": "bj"
         },
         ...
     ]
}
```

####  根据车辆名称 查询车辆列表

URL
```
    /bus/findListByName
```
参数
```$xslt
    type: 查询车辆类型，夜班或白班
    name: 车辆名称
```
注释
```$xslt
    type的值可为空,或者"night",为空时查询所有白班车辆，为"night"时查询夜班车辆
    name 为模糊查询
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [
        {
         "lineName": "441", //线路名称
         "defaultDirId": "4615109382646459114" //默认方向ID
         ...
     ]
}
```
#### 根据线路ID 查询车辆的始发站和终点站 返回数组

URL
```
    /bus/getLineDir
```
参数
```$xslt
    lineId: 线路ID 必填
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [
        {
            "name": "1(老山公交场站-四惠枢纽站)", //线路名称
            "value": "5276138694316562750"  //方向ID
        },
        {
            "name": "1(四惠枢纽站-老山公交场站)",
            "value": "5431016404622390237"
        }
    ]
}
```

#### 根据线路ID 查询车辆的始发站和终点站 返回对象

URL
```
    /bus/getDefaultLineDir
```
参数
```$xslt
    lineId: 线路ID 必填
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": {
        "dirId": "5055313442986205423",
        "dirName": "地铁天通苑北站-地铁龙泽站",
        "negativeDirId": "5495281241221180012",
        "negativeDirName": "地铁龙泽站-地铁天通苑北站"
    }
}
```

#### 根据线路ID和方向 查询车辆所有站点

URL
```
    /bus/getDirStation
```
参数
```$xslt
    lineId: 线路ID 必填
    dirId: 方向ID 必填
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [
        {
            "name": "老山公交场站",  //站点名称
            "value": "1"            //站点ID
        },
        {
            "name": "老山南路东口",
            "value": "2"
        },
        {
            "name": "地铁八宝山站",
            "value": "3"
        },
        {
            "name": "玉泉路口西",
            "value": "4" 
        },
        {
            "name": "永定路口东",
            "value": "5"
        },
        ......
    ]
}
```
#### 根据线路ID 查询默认方向上 车辆所有站点

URL
```
    /bus/getDefaultDirStation
```
参数
```$xslt
    lineId: 线路ID 必填
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": {
        "dirId": "5055313442986205423", //当前方向ID
        "dirName": "地铁天通苑北站-地铁龙泽站",//当前始发终点站
        "negativeDirId": "5495281241221180012",//反方向ID
        "stations": [
            {
                "name": "地铁天通苑北站",
                "value": "1"
            },
            {
                "name": "地铁天通苑北站南",
                "value": "2"
            },
            {
                "name": "天通西苑三区北门",
                "value": "3"
            },
            ...
        ]
    }
}
```
#### 根据线路ID,方向ID,站点ID 查询实时信息

URL
```
    /bus/getBusTime
```
参数
```$xslt
    lineId: 线路ID 必填
    dirId: 方向ID 必填
    stopId: 站点ID 必填
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": {
        "startEndStation": "地铁天通苑北站-地铁龙泽站",
        "lineId": "441", //当前线路
        "dirId": "5055313442986205423",//当前方向Id
        "stopId": "8", //当前站点Id
        "negativeDirId": "5495281241221180012",//反方向ID
        "negativeStopId": "13",//反方向站点Id
        "currentStop": "牛街",        //当前查询站点
        "operationTime": "5:00-24:00",//运营时间
        "priceType": "分段计价",       //计价方式
        "lastStop": "2",              //最近车辆距离几站
        "lastDistance": "1.03公里",   //最近车辆具体距离
        "expectedTime": "3分钟",      //预计到站时间
        "stopList": [                 //该线路所有站点
            {
                "stopId": "1",          //站点ID
                "stopName": "南菜园",    //站名
                "arriving": false,      //是否有途中车辆
                "arrived": true        //是否有到站车辆
            },
            {
                "stopId": "2",
                "stopName": "牛街",
                "arriving": false,
                "arrived": false
            },
            ...
            {   "stopId": "10",
                "stopName": "航天桥东",
                "arriving": true,
                "arrived": false
            }
        ]
    }
}
```

#### 收藏

URL
```
    /bus/collect
```
参数
```$xslt
    userId：用户ID
    lineId: 线路ID 必填
    dirId: 方向ID 必填
    stopId: 站点ID 必填
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": "请求成功"
}
```

#### 取消收藏

URL
```
    /bus/cancelCollect
```
参数
```$xslt
    collectId：收藏ID
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": "请求成功"
}
```

#### 收藏列表

URL
```
    /bus/getCollectList
```
参数
```$xslt
    userId：用户ID
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [
        {
            "id": 1,
            "userId": "1",
            "lineId": "441",
            "dirId": "5055313442986205423",
            "stopId": "8",
            "negativeDirId": "5495281241221180012",
            "currentStop": "天鑫家园",
            "nextStop": "华龙苑北里北门",
            "crtTime": 1517477871000
        },
        ...
    ]
}
```
