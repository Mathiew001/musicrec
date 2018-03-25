var app = getApp()
Page({
  data: {
    hasUserInfo: false,
    userInfo: null,
    nickName: "未登录"
  },
  
  myRec: function() {
    wx.navigateTo({
      url: '../myrec/myrec',
    })
  },

  myLike: function () {
    wx.navigateTo({
      url: '../mylike/mylike',
    })
  },

  onLoad: function (options) {
    if (app.globalData.userInfo != null) {
      this.setData({hasUserInfo:true})
      this.setData({ userInfo: app.globalData.userInfo })
    }
  },
  onReady: function () {

  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  }
})