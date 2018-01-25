class EndScene extends Scene {
    constructor(score) {
        super(gameSceneWidth, gameSceneHeight, id_game_background)
        this.endText = "GameOver"
        this.score = score
    }
    drawScene() {
        //先清空界面
        this.clear()
        //绘制物件
        var c = this.backGround.canvas
        var ctx = this.backGround.context
        // 创建渐变
        ctx.fillStyle = "#efee05"
        ctx.fillRect(0, 0, this.backGround.width, this.backGround.height);
        var gradient = ctx.createLinearGradient(0, 0, c.width, 0);
        gradient.addColorStop("0", "magenta")
        gradient.addColorStop("0.5", "blue")
        gradient.addColorStop("1.0", "red")
        ctx.font = "20px Georgia"
        ctx.fillStyle = gradient
        ctx.fontColor = "black"
        ctx.fillText(this.endText, 10, 50);
        ctx.font = "30px Verdana"
        ctx.fillStyle = gradient
        ctx.fillText("你获得了" + this.score.value + "分", 10, 90);
    }
}