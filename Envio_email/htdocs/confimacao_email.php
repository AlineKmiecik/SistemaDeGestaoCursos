<?php
     
    require_once('src/PHPMailer.php');
    require_once('src/SMTP.php');
    require_once('src/Exception.php');

    use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\SMTP;
    use PHPMailer\PHPMailer\Exception;
    
    $mail = new PHPMailer(true);
    $dados = json_decode(file_get_contents('php://input'), true);
    
    if($_GET["action"] == 'EnviarEmailConfirmacao'){
    
        $curso = $dados['nome'];
        $alunos = $dados['alunos'];

        /*echo json_encode($alunos[0]);*/

        $assunto = 'Cadastro do curso - '.$curso;

        foreach($alunos as $aluno ){
            $corpo = 'Olá '.$aluno['nome'].' <br>
            <br>
            Você foi cadastrado no curso de '.$curso;

            try {
                $mail->SMTPDebug = SMTP::DEBUG_SERVER;
                $mail->isSMTP();
                $mail->SMTPAuth = true;
                $mail->SMTPSecure = 'ssl';
                $mail->Host = 'br296.hostgator.com.br';
                $mail->Port = 465;
                $mail->isHTML(true);
                $mail->CharSet = 'UTF-8';
                $mail->Username = 'suporte@primegestaoempresarial.com';
                $mail->Password = 'gJqgY@DvD.}U';
                $mail->setFrom('suporte@primegestaoempresarial.com');
                $mail->addAddress($aluno['email']);
                $mail->Subject = $assunto;
                $mail->Body = $corpo;
                $mail->AltBody = '';
            
                if($mail->send()) {
                    echo 'Email enviado com sucesso';
                } else {
                    echo 'Email nao enviado';
                }
            } catch (Exception $e) {
                echo "Erro ao enviar mensagem: {$mail->ErrorInfo}";
            }
        }

        

        
    
    
    }

?>