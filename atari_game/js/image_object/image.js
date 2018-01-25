class GameImage {
    constructor(path, x = 0, y = 0) {
        this.image = imageFromPath(path)
        this.x = x
        this.y = y
        this.enableDrag = false
    }
    hasPoint(x, y) {
        var x1 = this.x, x2 = x1 + this.image.width
        var y1 = this.y, y2 = y1 + this.image.height
        var ret = false
        if (x1 <= x && x <= x2 && y1 <= y && y <= y2) {
            ret = true
        }
        return ret
    }
}
class MoveImage extends GameImage {
    constructor(path, x, y) {
        super(path, x, y)
        this.speedX = 6
        this.speedY = 6
    }

}