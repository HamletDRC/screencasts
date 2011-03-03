package pingpong

view = hbox {
    label(icon: imageIcon('/player1.png'))
    label(text: bind { model.message })
}