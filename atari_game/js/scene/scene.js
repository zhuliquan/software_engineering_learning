class Scene {
    constructor(width, height, id) {
        this.backGround = new BackGround(width, height, id)
    }
    initScene(game) {
    }
    drawScene() { }
    clear() {
        this.backGround.clear()
    }
}