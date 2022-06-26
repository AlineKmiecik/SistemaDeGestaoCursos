<?php 

include 'conexao.php';

require_once('src/PHPMailer.php');
require_once('src/SMTP.php');
require_once('src/Exception.php');
 
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\SMTP;
use PHPMailer\PHPMailer\Exception;

$mail = new PHPMailer(true);
$dados = json_decode(file_get_contents("php://input"));
$aux = 0;
$email = '';
$anexo = '';

//$mail->AddAttachment("/home/usuario/public_html/documento.pdf", "documento.pdf"); 

if($_GET["action"] == 'recuperarSenha'){

	$email = $dados->email;
	$sql = "SELECT distinct nome_completo,email,senha FROM usuarios WHERE email = '$email' LIMIT 1;";
	$result = mysqli_query($conexao, $sql);

    if(mysqli_num_rows($result)>0){
		$row = $result->fetch_assoc();
		$nome = explode(" ", $row['nome_completo']);
		$assunto = 'Laudos Medical Saúde - Recuperação de Senha';
		$corpo = 'Olá '.$nome[0].' <br>
		<br>
		Segue seus dados de acesso: <br>
		<br>
		E-mail: '.$row['email'].' <br>
		Senha: '.$row['senha'];
		$aux = 1;
    }

}elseif($_GET["action"] == 'laudoPorEmail'){

	$email = $dados->email;
	$anexo = $dados->anexo;
	$nome_anexo = $dados->nome_anexo;
	$assunto = 'Laudos Medical Saúde - Envio De Laudo - '.$nome_anexo;
	$nome = explode(" ", $dados->nome_completo);
	$corpo = 'Olá '.$nome[0].' <br>
	<br>
	Segue em anexo o laudo do produto: '.$nome_anexo.' solicitado pelo nosso site.<br>
	<br>
	At.te Medical Saúde';
	$aux = 1;

}

if($aux == 1){

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
		$mail->addAddress($email);
		$mail->Subject = $assunto;
		$mail->Body = $corpo;
		$mail->AltBody = '';
		if($anexo != ''){
			$mail->AddAttachment($anexo, $nome_anexo);
		} 
	
		if($mail->send()) {
			echo 'Email enviado com sucesso';
		} else {
			echo 'Email nao enviado';
		}
	} catch (Exception $e) {
		echo "Erro ao enviar mensagem: {$mail->ErrorInfo}";
	}
}

?>