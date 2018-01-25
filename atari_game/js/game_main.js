
var main = function () {
    var game = Game(1)
    //添加事件响应
    game.registerAction('a', paddleMoveLeft)
    game.registerAction('d', paddleMoveRight)
    game.registerAction('s', paddleMoveDown)
    game.registerAction('w', paddleMoveUp)
    game.registerAction("Enter", bulletMove)
    //键盘事件监听
    window.addEventListener('keydown', function (event) {
        var key = event.key
        if (key == " ") {
            game.pause()
        } else {
            game.isKeyDowns[key] = true
        }
    })
    window.addEventListener('keyup', function (event) {
        var key = event.key
        if (key != "Enter" && key != " ") {
            //有特殊要求的按键要跳过
            game.isKeyDowns[key] = false
        }
    })
    game.loadScene()//加载背景图片
    game.start()//开始游戏
}