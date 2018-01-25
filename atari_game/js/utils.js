var log = console.log.bind(console)
var onloadNum = 0
//拖拽调整函数
var dragDebugMode = function (mode, scene, dragBlock) {
    //用于拖拽调试
    if (!mode) {
        return
    }
    var canvas = scene.backGround.canvas
    canvas.addEventListener('mousedown', function (event) {
        if (dragBlock.hasPoint(event.offsetX, event.offsetY)) {
            dragBlock.enableDrag = true
        }
    })
    canvas.addEventListener('mousemove', function () {
        if (dragBlock && dragBlock.enableDrag) {
            dragBlock.x = event.offsetX
            dragBlock.y = event.offsetY
            scene.drawScene()
        }
    })
    canvas.addEventListener('mouseup', function () {
        if (dragBlock) {
            dragBlock.enableDrag = false
        }
    })
}
//帧率调整调试函数
var speedDebugMode = function (mode, game) {
    if (!mode) {
        return
    }
    var speedSwitch = game.speedSwitch
    //改变速度监听
    speedSwitch.addEventListener('input', function (event) {
        game.fps = (Number(speedSwitch.value) + 10) * 0.6
    })
}
//返回图像的函数
var imageFromPath = function (path, context) {
    var image = new Image()
    image.src = path
    image.onload = function () {
        onloadNum += 1
    }
    return image
}
//载入关卡
var onloadLevel = function (levelNum) {
    //载入关卡的数目
    var blocks = []
    var level = levels[levelNum]
    var infos = level['blocks']
    for (var i = 0; i < infos.length; i++) {
        var hpNum = infos[i][2]
        var blockPath = '../img/block' + hpNum + '.JPG'
        var b = new GameBlock(blockPath,
            infos[i][0], infos[i][1],
            hpNum, hpNum * 10)
        blocks.push(b)
    }
    return blocks
}
//反弹处理函数
var collisionProcess = function (bullet, block) {
    var a = bullet, b = block
    var isProcess = false
    //反弹处理
    if (a.isCollisionY(b)) {
        a.reflectY()
        isProcess = true
    } else if (a.isCollisionX(b)) {
        a.reflectX()
        isProcess = true
    }
    return isProcess
}
//移动操作
var paddleMoveLeft = function (scene) {
    var paddle = scene.paddle
    paddle.moveLeft()
}
var paddleMoveRight = function (scene) {
    var paddle = scene.paddle
    paddle.moveRight()
}
var paddleMoveDown = function (scene) {
    var paddle = scene.paddle
    paddle.moveDown()
}
var paddleMoveUp = function (scene) {
    var paddle = scene.paddle
    paddle.moveUp()
}
var bulletMove = function (scene) {
    var bullet = scene.bullet
    bullet.move()
}
