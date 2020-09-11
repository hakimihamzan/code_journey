from time import sleep

def announce(f):
    def wrapper():
        print('about to run function')
        sleep(1)
        f()
        sleep(1)
        print('done with that')
        sleep(2)

    return wrapper

@announce
def hello():
    print('Hi everybody')

hello()


def testing(f):
    def wrapper():
        print('adding something')
        sleep(2)
        f()
        sleep(2)
        print('done adding')
        sleep(2)

    return wrapper


@testing
def hi():
    print('hi')

hi()
