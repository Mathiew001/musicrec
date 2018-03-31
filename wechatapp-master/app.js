App({
  globalData: {
    userInfo: null,
    userId: null,
  },
  /**
   * 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）
   */
  onLaunch: function () {
    var that = this
    if (this.globalData.userInfo == null) {     
      wx.login({
        success: function (res) {
          if (res.code) {
            wx.request({
              url: 'https://api.weixin.qq.com/sns/jscode2session?appid=wxffbd0a2255e45e93&secret=f2597c0e8c81a8d2356a7960d386498e&js_code=' + res.code + '&grant_type=authorization_code',
              method: 'GET',
              success: function (res) {
                // console.log(res)
                that.globalData.userId = res.data.openid
                if (that.userInfoReadyCallback) {
                  that.userInfoReadyCallback(res)
                }
              }
            })
          } else {
            console.log('获取用户登录态失败！' + res.errMsg)
          }
          wx.getUserInfo({
            success: function (res) {
              that.globalData.userInfo = res.userInfo,
              console.log(res)
              wx.request({
                url: "http://59.111.105.184/login",
                data: {
                  userId: that.globalData.userId,
                  nickName: that.globalData.userInfo.nickName,
                  avatarUrl: that.globalData.userInfo.avatarUrl,
                  city: that.globalData.userInfo.city,
                  province: that.globalData.userInfo.province,
                  country: that.globalData.userInfo.country
                }
              })
            },
            fail: function () {
              wx.showModal({
                title: '警告',
                content: '您点击了拒绝授权,将无法正常显示个人信息,点击确定重新获取授权。',
                success: function (res) {
                  if (res.confirm) {
                    wx.openSetting({
                      success: (res) => {
                        if (res.authSetting["scope.userInfo"]) {
                          wx.getUserInfo({
                            success: function (res) {
                              that.globalData.userInfo = res.userInfo
                            }
                          })
                        }
                      }
                    })
                  }
                }
              })
            }
          })
        }
      })
    }
  },

  /**
   * 当小程序启动，或从后台进入前台显示，会触发 onShow
   */
  onShow: function (options) {
    
  },

  /**
   * 当小程序从前台进入后台，会触发 onHide
   */
  onHide: function () {
    
  },

  /**
   * 当小程序发生脚本错误，或者 api 调用失败时，会触发 onError 并带上错误信息
   */
  onError: function (msg) {
    
  }
})
