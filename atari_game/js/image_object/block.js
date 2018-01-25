class GameBlock extends GameImage {
    constructor(path, x, y, hp = 1, score = 1) {
        super(path, x, y)
        this.hp = hp
        this.score = score
    }
    isAlive() {
        return this.hp > 0
    }
    loseLife() {
        this.hp -= 1
    }
}