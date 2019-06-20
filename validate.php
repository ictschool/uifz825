<?php

  //var_dump($_POST['check1']);
  //var_dump($_POST['check2']);

  //if($_POST['email'] != "")
  //if(!empty($_POST['email']))
  if(strlen($_POST['email']) > 2
    && filter_var($_POST['email'], FILTER_VALIDATE_EMAIL))
    var_dump($_POST['email']);

    echo "<br>";

    //$test=$_POST['password'];
    //var_dump(shell_exec($test));

    //var_dump($_FILES['file']);
    /*
    $filepath = __DIR__."/upload/".$_FILES['file']['name'];
    if(move_uploaded_file($_FILES['file']['tmp_name'], $filepath)){
      echo "Bravo File ".$_FILES['file']['name']." wurde hochgeladen";
    }*/

    function rearrange( $arr ){
        foreach( $arr as $key => $all ){
            foreach( $all as $i => $val ){
                $new[$i][$key] = $val;
            }
        }
        return $new;
    }

    var_dump($_FILES['file']);

    $size = count($_FILES['file']['name']);
    for($i = 0; $i < $size; $i++){
      $filepath = __DIR__."/upload/".$_FILES['file']['name'][$i];
      if(move_uploaded_file($_FILES['file']['tmp_name'][$i], $filepath)){
        echo "Bravo File ".$_FILES['file']['name'][$i]." wurde hochgeladen<br>";
      }
    }

    echo "<br>";

    var_dump(rearrange($_FILES['file']));

    foreach(rearrange($_FILES['file']) as $file){
      $filepath = __DIR__."/upload/".$file['name'];
      if(move_uploaded_file($file['tmp_name'], $filepath)){
        echo "Bravo File ".$file['name']." wurde hochgeladen<br>";
      }
    }

    echo "<br>";

  if(isset($_POST['check']))
    var_dump($_POST['check']);

  //header('location:form1.html');
 ?>
