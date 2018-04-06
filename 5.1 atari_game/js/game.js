var Game = function (levelNum = 0) {
    var o = {}
    //初始化参数
    o.score = new Score("id_score")
    o.scene = new GameScene(levelNum)
    o.fps = levels[levelNum]['fps']
    o.isPause = true  //表示是否暂停
    o.isLoad = false  //表示是否加载图像
    o.actions = {}
    o.isKeyDowns = {}
    //开始游戏
    o.start = function () {
        var timer = setInterval(function () {
            if (o.isLoad) {//图像加载完成了才可以开始游戏
                o.isPause = false//变成不是开始状态
                o.runLoop()//开始事件循环
                clearInterval(timer)
            }
        }, 1)
        dragDebugMode(true, o.scene, o.scene.bullet)
    }
    //暂停游戏
    o.pause = function () {
        o.isPause = !o.isPause//反转开始状态
    }
    //加载背景
    o.loadScene = function () {
        //加载场景，加载完毕之后将游戏设置可以运行状态
        o.scene.initScene(o)
    }
    //改变帧率
    o.changeFps = function (fps) {
        o.fps = fps
    }
    //更换场景
    o.replaceScene = function (scene) {
        o.scene = scene
        o.scene.drawScene()
    }
    //更新每一帧游戏状态
    o.update = function () {
        //更新坐标
        var actions = Object.keys(o.actions)
        for (var i = 0; i < actions.length; i++) {
            var key = actions[i];
            if (o.isKeyDowns[key]) {
                o.actions[key](o.scene)
            }
        }
        //碰撞判断
        o.scene.sceneCollisionProcess(o.score)
        //重新绘图
        o.scene.drawScene()
        //更新分数
        o.score.updateScore()
    }
    //注册事件
    o.registerAction = function (key, callback) {
        o.actions[key] = callback
        o.isKeyDowns[key] = false
    }
    //事件循环
    o.runLoop = function () {
        if (!o.isPause) {
            //更新游戏画面
            o.update()
            if (onloadNum == 2) {//结束了要更换结束的界面
                var endScene = new EndScene(o.score)
                o.replaceScene(endScene)
                o.isPause = true
            }
        }
        setTimeout(o.runLoop, 1000 / o.fps)//暂停一段时间
    }
    return o
}