class GameBullet extends MoveImage {
    constructor(path, x = 0, y = 0) {
        super(path, x, y)
        this.x = 200
        this.y = 400
    }
    move() {
        this.x += this.speedX
        this.y += this.speedY
        if (this.x <= 0 || this.x + this.image.width >= gameSceneWidth) {
            this.reflectX()
        }
        if (this.y <= 0 || this.y + this.image.height >= gameSceneHeight) {
            this.reflectY()
        }
    }
    reflectX() {
        //反弹
        this.speedX *= -1
    }
    reflectY() {
        //反弹
        this.speedY *= -1
    }
    isCollisionX(otherObj) {
        //otherObj 是与之碰撞的物体
        var ret = false
        var b = otherObj
        var uy = this.y, dy = this.y + this.image.height
        if ((b.y < uy && uy < b.y + b.image.height) ||
            (b.y < dy && dy < b.y + b.image.height)
        ) {
            ret = ((this.x >= b.x && this.speedX < 0 && this.x - b.x <= b.image.width) ||
                (this.x <= b.x && this.speedX > 0 && b.x - this.x <= this.image.width))
        }
        return ret
    }
    isCollisionY(otherObj) {
        //otherObj 是与之碰撞的物体
        var ret = false
        var b = otherObj
        var lx = this.x, rx = this.x + this.image.width
        if ((b.x < lx && lx < b.x + b.image.width) ||
            (b.x < rx && rx < b.x + b.image.width)
        ) {
            ret = ((this.y > b.y && this.speedY < 0 && this.y - b.y <= b.image.height) || (this.y < b.y && this.speedY > 0 && b.y - this.y <= this.image.height))
        }
        return ret
    }
}