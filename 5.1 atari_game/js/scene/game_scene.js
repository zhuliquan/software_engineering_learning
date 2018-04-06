class GameScene extends Scene {
    constructor(levelNum) {
        //初始化的参数可以看game_scene_param
        super(gameSceneWidth, gameSceneHeight, id_game_background)
        this.imageNum = levels[levelNum]['blocks'].length + 2
        this.blocks = onloadLevel(levelNum)
        this.paddle = new GamePaddle(paddlePath)
        this.bullet = new GameBullet(bulletPath)
    }
    drawScene() {
        //先清空界面
        this.clear()
        //绘制物件
        var ctx = this.backGround.context
        ctx.fillRect(0, 0, this.backGround.width, this.backGround.height);
        this.backGround.draw(this.paddle)
        this.backGround.draw(this.bullet)
        for (var i = 0; i < this.blocks.length; i++) {
            var b = this.blocks[i]
            if (b.isAlive()) {
                this.backGround.draw(b)
            }
        }
    }
    initScene(game) {
        super.initScene()
        var imageNum = this.imageNum
        // 等待图像加载完成
        var timer = setInterval(function () {
            if (onloadNum == imageNum) {
                game.isLoad = true
                clearInterval(timer)
            }
        }, 1)
    }
    sceneCollisionProcess(score) {
        var blocks = this.blocks
        var bullet = this.bullet
        var paddle = this.paddle
        collisionProcess(bullet, paddle)
        for (var i = 0; i < blocks.length; i++) {
            var b = blocks[i]
            if (b.isAlive() && collisionProcess(bullet, b)) {
                b.loseLife()
                if (b.hp == 0) {//死了就要增加分数
                    score.increase(b)
                    onloadNum--
                }
                break;
            }
        }
    }
}