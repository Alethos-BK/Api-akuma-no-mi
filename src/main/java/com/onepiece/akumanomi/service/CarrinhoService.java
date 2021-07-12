package com.onepiece.akumanomi.service;

import java.util.Arrays;
import java.util.List;

import com.onepiece.akumanomi.email.Mailler;
import com.onepiece.akumanomi.email.MensagemEmail;
import com.onepiece.akumanomi.model.Carrinho;
import com.onepiece.akumanomi.model.fruta.AkumaNoMi;
import com.onepiece.akumanomi.repository.CarrinhoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    CarrinhoRepository _carrinhoRepository;

    AkumaNoMi _frutaRepository;

    @Autowired
    Mailler mailler;

    public List<Carrinho> obterTodos() {
        return _carrinhoRepository.findAll();
    }

    public Carrinho criarPedido(Carrinho carrinho){

        Carrinho carrinhoSalvo = this._carrinhoRepository.save(carrinho);
        enviarEmail(carrinhoSalvo);

        return carrinhoSalvo;
    }

    public void enviarEmail(Carrinho carrinho){

        String imagem = "";
        for (AkumaNoMi fruta : carrinho.getListaFrutas()) {
           imagem += "<img src=" + fruta.getImagemFruta() + " style=\"width: 100px; margin-Left: 7px; \">" ;
        }
        String mensagem = "<!DOCTYPE html><html lang=\\\"pt-br\\\"><head> <meta charset=\\\"UTF-8\\\"> <meta name=\\\"viewport\\\" content="
                           + "\\\"width=device-width, initial-scale=1.0\\\"> <title>Obrigado e Volte sempre !</title></head><body> <header>"
                           +" </header> <div style=\\\"width: 80%; margin:auto;\\\"> <section id=\\\"\\\"> <div style=\\\"text-align: center;\\\">"
                           +"<h2 style=\\\"font-family:cursive;font-size: 12;\\\">Eu não sei usar espadas, não sei navegar, também não "
                           +"cozinhar e não sei mentir, o que eu sei, é que dependo dos meus amigos se quiser continuar vivendo! <br/>"
                           +"Obrigado por comprar comigo e meus nakamas.<br/> Seja muito bem vindo(a) aos Straw Hat Pirates !</h2> </div>"
                           +"<div class=\\\"container\\\"> <div class=\\\"row\\\" style=\\\"font-family: cursive;font-size: 12; max-width: 40rem;\\\" >"
                           +"<div class=\\\"card\\\"> <img src=\\\"https://i.pinimg.com/originals/6f/66/30/6f66309d4fb6946f515ab8a2c55733c5.png\\\" style=\\\"width: 100px;"
                           +"height: 150px;\\\" class=\\\"card-img-top\\\" alt=\\\"Luffy Agradecido\\\"> <div class=\\\" card-body\\\"> %s <p>Eu ouvi dizer que"
                           +"são encarnações dos demônios dos mares. Se você comer uma, você vai ganhar uma habilidade especial, mas o mar vai"
                           +" te odiar e você não conseguirá mais nadar!</p></div><div class=\\\"botao\\\" style=\\\"text-align: center;\\\">"
                           +"<a href=\\\"https://onepiece.fandom.com/pt/wiki/Akuma_no_Mi\\\" class=\\\"btn btn-primary\\\">Ver mais</a>"
                           +"</div></div></section> <footer class=\\\"rodape text-lg-start\\\"> <div class=\\\"text-center p-3\\\" "
                           +"style=\\\"background-color: rgba(0, 0, 0, 0.2);\\\"> © 2021 Copyright: </div></footer> </div></body></html>";
                            // mensagem = String.format(mensagem, imagem);

        MensagemEmail email = new MensagemEmail(("Pedido finalizado"), mensagem, Arrays.asList("storestorenomi@gmail.com", carrinho.getEmail()));
        mailler.enviar(email);
    
    }
}
