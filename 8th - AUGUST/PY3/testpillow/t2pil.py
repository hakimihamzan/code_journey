from PIL import Image, ImageFilter
import os

#open file ------------------------------
#img1 = Image.open('me3.jpg')
#img1.show()

#img1.save('m3.png')

## save to png--------------------------- need to import os
##for fil in os.listdir('.'):
##    if fil.endswith('.jpg'):
##        i = Image.open(fil)
##        fn, text = os.path.splitext(fil)
##        print(fn, "---space---", text)
##        i.save('pngs/{}.png'.format(fn))

# resize file---------------------

##size_300 = (300,300) #tuple size
##size_700 = (700,700)
##size_1080p = (1920,1080)
##
##for fil in os.listdir('.'):
##    if fil.endswith('.jpg'):
##        i = Image.open(fil)
##        fn, text = os.path.splitext(fil)
##        print(fn, "---space---", text)
##        #i.thumbnail(size_300)
##        #i.thumbnail(size_700)
##        i.thumbnail(size_1080p) # resize part
##        i.save('1080p/{}_1080.{}'.format(fn, text)) # save to a folder


#-------------------   rotate
##img1 = Image.open('me3.jpg')
##img1.rotate(90).save('me3_mod_90.jpg')

###-----------convert bnw
##img1 = Image.open('me3.jpg')
##img1.convert(mode='L').save('me3_mod_bnw.jpg')

#-------------- blurred
img1 = Image.open('me3.jpg')
img1.filter(ImageFilter.GaussianBlur(5)).save('me3_mod_gaus.jpg')























