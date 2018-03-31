//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    animationData: {},
    listItems: [],
    cardImages: ['../../images/card1.jpg', '../../images/card2.jpg',
      '../../images/card3.jpg'],
    userId: null
  },

  //事件处理函数
  slidethis: function(e) {
    var animation = wx.createAnimation({
      duration: 300,
      timingFunction: 'cubic-bezier(.8,.2,.1,0.8)',
    });
    var self = this;
    this.animation= animation;
    this.animation.translateY(-420).rotate(-5).translateX(0).step();
    this.animation.translateY(62).translateX(25).rotate(0).step();
    this.setData({
      animationData: this.animation.export()
    });
    setTimeout(function() {
      var listItems = self.data.listItems;
      var slidethis = self.data.listItems.shift();
      self.data.listItems.push(slidethis);
      self.setData({
        listItems: self.data.listItems,
        animationData: {}
      });
    }, 350);
  },

  like: function (e) {
    console.log(e)
    var that = this
    var id = e.target.id.split("=")[0]
    var doLike = e.target.id.split("=")[1]
    if (doLike == "true") {
      wx.request({
        url: 'http://59.111.105.184/pro/like',
        data: {
          musicId: id,
          userId: app.globalData.userId,
          doLike: doLike
        },
        success: function (res) {
          var i = 0
          while (i < that.data.listItems.length) {
            if (that.data.listItems[i].id == id) {
              var l = that.data.listItems
              l[i]["doLike"] = false
              that.setData({ listItems: l })
              var a = "listItems[" + i + "].likeNumber"
              var b = res.data
              that.setData({ [a]: b })
              break
            }
            i++
          }
        }
      })
    }
    else if (doLike == "false") {
      wx.request({
        url: 'http://59.111.105.184/pro/like',
        data: {
          musicId: id,
          userId: app.globalData.userId,
          doLike: doLike
        },
        success: function (res) {
          var i = 0
          while (i < that.data.listItems.length) {
            if (that.data.listItems[i].id == id) {
              var l = that.data.listItems
              l[i]["doLike"] = true
              that.setData({ listItems: l })
              var a = "listItems[" + i + "].likeNumber"
              var b = res.data
              that.setData({ [a]: b })
              break
            }
            i++
          }
        }
      })
    }
  },

  profileClick: function(e) {
    var userId = e.currentTarget.id
    wx.navigateTo({
      url: '../other/other?userId=' + userId,
    })
  },

  onLoad: function () {
    var that = this
    if(app.globalData.userId) {
      this.setData({ userId: app.globalData.userId })
    }
    else {
      app.userInfoReadyCallback = res => {
        that.setData({ userId: res.data.openid })
      }  
    }
    setTimeout(function getList() {
      wx.request({
        url: "http://59.111.105.184/list/topthree",
        data: {
          userId: app.globalData.userId
        },
        method: 'GET',
        success: function (res) {
          var l = that.data.listItems
          for (var i = 0; i < 3; i++) {
            l.push(res.data[i])
            l[i]["cardImages"] = that.data.cardImages[i]
          }
          that.setData({ listItems: l })
          console.log(that.data.listItems)
        },
        fail: function (res) {
          console.log(".....fail.....");
        }
      }) 
    }, 800)
  },
})
