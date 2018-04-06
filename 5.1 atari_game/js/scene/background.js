class BackGround {
    constructor(width, height, id) {
        this.canvas = document.getElementById(id)
        this.context = this.canvas.getContext("2d")
        this.canvas.width = width
        this.canvas.height = height
        this.width = this.canvas.width
        this.height = this.canvas.height
        this.context.fillStyle = sceneBackColor
    }
    draw(obj) {
        // obj需要绘制的对象
        this.context.drawImage(obj.image, obj.x, obj.y)
    }
    clear() {
        this.context.clearRect(0, 0, this.width, this.height)
    }
}