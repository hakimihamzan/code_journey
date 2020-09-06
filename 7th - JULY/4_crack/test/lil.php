<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MD5 crack</title>
</head>
<body>
    <h1>MD5 Cracker</h1>
    <p>
    This application takes an MD5 hash of 4 digits PIN and check
    all 10000 possible 4 digits PINs to determine the PIN.
    </p>
    <pre>
debug output:
        <?php
            $text = 'Put your hash code';
            if(!empty($_GET['md5'])){
                $time_pre = microtime(true);
                $md5 = $_GET['md5'];
                $try = 0;
                $PIN = NULL;
                echo "\n";
                for($i=0; $i<=9999; $i++){
                    $try = hash('md5',$i);
                    if ($i<7) echo "$try : $i \n";
                    if ($i==8) echo "... ... ... ...\n";
                    if ($try==$md5) {
                        $PIN = $i;
                        break;
                    }
                }
                if($i>15){
                    for($j=$i-7; $j<$i; $j++){
                        $try = hash('md5',$j);
                        echo "$try : $j \n";
                    }
                }
                if ($PIN != NULL) $text="The PIN is: $PIN\n";
                else $text = "PIN not found\n";
                $time_post = microtime(true);
                print "Elapsed time: ";
                print $time_post-$time_pre;
                print "\n";
            }
        ?>
    </pre>
    <p>Hash Code:<?= htmlentities($md5); ?></p>
    <p><?= htmlentities($text); ?></p>
    <form>
        <input type="text" name="md5" size="40" />
        <input type="submit" value="Crack MD5"/>
    </form>
</body>
</html>
