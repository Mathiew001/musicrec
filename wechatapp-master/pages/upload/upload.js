var app=getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    
  },
  submitform: function (e) {
    wx.request({
      url: "http://localhost:8080/upload",
      data: {
        userId: app.globalData.userId,
        musicSrc: e.detail.value.input_music,
        posterSrc: e.detail.value.input_poster,
        musicName: e.detail.value.input_name,
        musicAuthor: e.detail.value.input_author,
        musicComment: e.detail.value.input_comm
      },
      method: 'GET',
      success: function (res) {
        if (res.data.errcode == 1) {
          wx.showToast({
            title: '音乐资源地址不能为空， 请重新输入',
            icon: "none"
          })
        } 
        else if (res.data.errcode == 2){
          wx.showToast({
            title: '音乐名称不能为空， 请重新输入',
            icon: "none"
          })
        }
        else if (res.data.errcode == 3) {
          wx.showToast({
            title: '音乐作者不能为空， 请重新输入',
            icon: "none"
          })
        }
        else if (res.data.errcode == 0) {
          wx.showToast({
            title: '上传成功'
          })
        }
      },
      fail: function (res) {
        console.log(".....fail.....");
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
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