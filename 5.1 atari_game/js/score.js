class Score {
    constructor(id) {
        this.value = 0
        this.scoreText = document.getElementById(id)
    }
    increase(obj) {
        //根据杀死的对象来添加分数
        this.value += obj.score
    }
    updateScore() {
        //更新分数
        this.scoreText.value = this.value
    }
}