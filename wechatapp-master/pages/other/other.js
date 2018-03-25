var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userId: null,
    listItems: []
  },

  like: function (e) {
    var that = this
    var id = e.target.id.split("=")[0]
    var doLike = e.target.id.split("=")[1]
    var index = e.target.id.split("=")[2]
    if (doLike == "true") {
      wx.request({
        url: 'http://localhost:8080/like',
        data: {
          musicId: id,
          userId: app.globalData.userId,
          doLike: doLike
        },
        success: function (res) {
          console.log(res.data)
          var l = that.data.listItems
          l[index]["doLike"] = false
          that.setData({ listItems: l })
          var a = "listItems[" + index + "].musicrec.likeNumber"
          var b = res.data
          that.setData({ [a]: b })
        }
      })
    }
    else {
      wx.request({
        url: 'http://localhost:8080/like',
        data: {
          musicId: id,
          userId: app.globalData.userId,
          doLike: doLike
        },
        success: function (res) {
          var l = that.data.listItems
          l[index]["doLike"] = true
          that.setData({ listItems: l })
          var a = "listItems[" + index + "].musicrec.likeNumber"
          var b = res.data
          that.setData({ [a]: b })
        }
      })
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("onLoad")
      var that = this
      this.setData({userId: options.userId})
      wx.request({
        url: 'http://localhost:8080/list/hisrec',
        data: {
          myUserId: app.globalData.userId,
          hisUserId: that.data.userId
        },
        success: function (res) {
          var l = that.data.listItems
          for (var i = 0; i < res.data.length; i++) {
            l.push(res.data[i])
          }
          that.setData({
            listItems: l
          });
        }
      })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})