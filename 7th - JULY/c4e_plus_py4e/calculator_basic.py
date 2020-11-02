import SimpleGUICS2Pygame.simpleguics2pygame as simplegui

store = 0
operand = 0

def output() :
    print ("Store = ", store)
    print ("Operand = ", operand)

def swap() :
    global store, operand
    store, operand = operand, store
    output()

def add() :
    global store,operand
    store = store + operand
    output()

def sub() :
    global store, operand
    store = store - operand
    output()

def div() :
    global store, operand
    store = store / operand
    output()

def mult() :
    global store, operand
    store = store * operand
    output()

def input_handler (inpu):
    global operand
    operand = float(inpu)
    output()


frame = simplegui.create_frame("frame", 300, 300)
frame.add_button("Print", output, 100)
frame.add_button("Swap", swap, 100)
frame.add_button("Add", add, 100)
frame.add_button("Substract", sub, 100)
frame.add_button("Divide", div, 100)
frame.add_button("Multiply", mult, 100)
frame.add_input("Enter operand", input_handler, 100)

frame.start()