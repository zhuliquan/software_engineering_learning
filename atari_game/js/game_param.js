var gameSceneWidth = 400
var gameSceneHeight = 550
var sceneBackColor = "grey"
var paddlePath = "../img/paddle.JPG"
var bulletPath = "../img/bullet.JPG"
var id_game_background = "id_game_background"
var levels = [
    //leve0用于编辑器使用的
    {
        'fps': 25,
        'blocks': [],
    },
    //level1
    {
        'fps': 20,
        'blocks':
        //x y hp
        [
            [10, 10, 1],
        ],
    },
    //level2
    {
        'fps': 20,
        'blocks':
        [
            [50, 50, 3],
            [100, 100, 2],
            [100, 50, 2],
            [300, 80, 1],
            [300, 200, 1],
        ],
    },
]