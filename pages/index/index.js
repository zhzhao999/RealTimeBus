//list.js
//获取应用实例
var app = getApp()
var api = require('../../utils/api.js')

Page({
  data: {
    id: null, //用户id
    lists: {},
    winHeight:"",//窗口高度
    currentTab:0 //预设当前项的值
  },
  // 滚动切换标签样式
  switchTab:function(e){
      this.setData({
          currentTab:e.detail.current
      });
  },
  // 点击标题切换当前页时改变样式
  swichNav:function(e){
      var cur=e.target.dataset.current;
      if(this.data.currentTaB==cur){
        return false;
      }else{
        this.setData({
            currentTab:cur
        })
      }
  },
  onLoad: function() {  
      var that = this; 
      //  高度自适应
      wx.getSystemInfo({
          success: function( res ) {
            var clientHeight=res.windowHeight,
                clientWidth=res.windowWidth,
                rpxR=750/clientWidth;
            var calc=clientHeight*rpxR-180;
              console.log(calc)
              that.setData({
                  winHeight: calc  
              })
          }  
      })

      this.setData({
        id: wx.getStorageSync('id')
      })

      console.log(this.data.id)


  },
  onPullDownRefresh () {
    wx.stopPullDownRefresh()
  }
})

/*Page({
  data: {
    lists: {},
    winHeight:"",//窗口高度
    currentTab:0, //预设当前项的值
    scrollLeft:0, //tab标题的滚动条位置
    expertList:[{ //假数据
        img:"avatar.png",
        name:"欢顔",
        tag:"知名情感博主",
        answer:134,
        listen:2234
    }]
  },
  // 滚动切换标签样式
  switchTab:function(e){
      this.setData({
          currentTab:e.detail.current
      });
      this.checkCor()
  },
  // 点击标题切换当前页时改变样式
  swichNav:function(e){
      var cur=e.target.dataset.current;
      if(this.data.currentTaB==cur){
        return false;
      }else{
        this.setData({
            currentTab:cur
        })
      }
  },
  //判断当前滚动超过一屏时，设置tab标题滚动条。
  checkCor:function(){
    if (this.data.currentTab>4){
      this.setData({
        scrollLeft:300
      })
    }else{
      this.setData({
        scrollLeft:0
      })
    }
  },
  onLoad: function() {  
      var that = this; 
      //  高度自适应
      wx.getSystemInfo({
          success: function( res ) {
            var clientHeight=res.windowHeight,
                clientWidth=res.windowWidth,
                rpxR=750/clientWidth;
            var calc=clientHeight*rpxR-180;
              console.log(calc)
              that.setData({
                  winHeight: calc  
              })
          }  
      })
  },
  onPullDownRefresh () {
    wx.stopPullDownRefresh()
  }
})*/