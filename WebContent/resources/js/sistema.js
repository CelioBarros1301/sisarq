/*
 * Nome.....: SomenteNumero
 * Objetivo.: So permitir numero em caixa de texto
 * Paramento: e (evento)
 * Retorno..: True  - Se for so Numero
 *            False - Diferente de Numero
 * Autor....: Celio Barros
 * Data.....: 07/08/2018
 * Alteracao:
 */
function SomenteNumero(e){
	var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }
}

/*
 * Nome.....: LetraNumero
 * Objetivo.: So permitir Letra,Numero e os caracteres especias 'Traco-' 'Espaco em Branco'
 * Paramento: e (evento)
 * Retorno..: True  - Se for Letra,Numero e os caracteres especias 'Traco-' 'Espaco em Branco'
 *            False - Diferente de Letra,Numero e os caracteres especias 'Traco-' 'Espaco em Branco'
 * Autor....: Celio Barros
 * Data.....: 07/08/2018
 * Alteracao:
 */
function LetraNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if( (tecla>47 && tecla<58) || (tecla>64 && tecla<91) || (tecla>96 && tecla<123 ) || (tecla==32) || (tecla==45)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }
}


/*
 * Nome.....: LetraMaisucula
 * Objetivo.: So permitir Letra Maiscula e os caracteres especias 'Traco-' 'Espaco em Branco'
 * Paramento: e (evento)
 * Retorno..: True  - Se for Letra Maiscula e os caracteres especias 'Traco-' 'Espaco em Branco'
 *            False - Diferente de Letra Maiscula e os caracteres especias 'Traco-' 'Espaco em Branco'
 * Autor....: Celio Barros
 * Data.....: 07/08/2018
 * Alteracao:
 */
function LetraMaiscula(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if(  (tecla>64 && tecla<91) ||  (tecla==32) || (tecla==45)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }
}

/*
 * Nome.....: ZerosEsquerda
 * Objetivo.: Incluir Zeros a Esquerda
 * Paramento: objControle - nome da tag de INPUT do HTML
 *            intTam      - Tamanho da Variavel
 * Retorno..: Atualiza o valor do input TEXT 
 *            Ex: ZerosEsquera(3,5) Retorno: 00003
 * Autor....: Celio Barros
 * Data.....: 07/08/2018
 * Alteracao:
 */

function ZerosEsquerda(objControle,intTam)
{
	var strCodigo=objControle.value;
	strCodigo="0".repeat(intTam)+strCodigo.trim();
	objControle.value=Right(strCodigo,intTam);
    
}

/*
 * Nome.....: Left
 * Objetivo.: Retornar n caracteres pela esquerada
 * Paramento: strr - Valor 
 *            n    - Numero de caracteres pela esquerda
 * Retorno..: Retornar n caracteres pela esquerada
 * Autor....: Celio Barros
 * Data.....: 07/08/2018
 * Alteracao:
 */
function Left(str, n){
	if (n <= 0)
	    return "";
	else if (n > String(str).length)
	    return str;
	else
	    return String(str).substring(0,n);
}

/*
 * Nome.....: Right
 * Objetivo.: Retornar n caracteres pela Direita
 * Paramento: strr - Valor 
 *            n    - Numero de caracteres pela Direita
 * Retorno..: Retornar n caracteres pela Direita
 * Autor....: Celio Barros
 * Data.....: 07/08/2018
 * Alteracao:
 */
function Right(str, n){
    if (n <= 0)
       return "";
    else if (n > String(str).length)
       return str;
    else {
       var iLen = String(str).length;
       return String(str).substring(iLen, iLen - n);
    }
}



