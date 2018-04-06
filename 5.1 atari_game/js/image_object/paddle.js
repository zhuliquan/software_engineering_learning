class GamePaddle extends MoveImage {
    constructor(path, x, y) {
        super(path, x, y)
        this.x = 10
        this.y = 450
        this.speedX = 5
        this.speedY = 5
    }
    moveLeft() {
        this.x -= this.speedX
    }
    moveRight() {
        this.x += this.speedX
    }
    moveUp() {
        this.y -= this.speedY
    }
    moveDown() {
        this.y += this.speedY
    }
}