package pingpong

view = hbox {
    label(text: bind {model.message})
    label(icon: imageIcon('/player2.png'))
}