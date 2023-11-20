package com.example.application.views.termo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;

public class Tentativas {
    private String tentativa;
    private Dicionario palavra;

    public Tentativas(String tentativa, Dicionario palavra) {
        this.tentativa = tentativa;
        this.palavra = palavra;
    }

    public void checarTentativa(Div results) {
        Div div = new Div();

        for (int i = 0; i < tentativa.length(); i++) {
            String letter = tentativa.substring(i, i + 1);
            Span badge = new Span(letter);
            if (letter.equals(palavra.getPalavra().substring(i, i + 1))) {
                badge.getElement().getThemeList().add("badge success");
            } else if (palavra.getPalavra().indexOf(letter) > -1) {
                badge.getElement().getThemeList().add("badge");
            } else {
                badge.getElement().getThemeList().add("badge contrast");
            }
            div.add(badge);
        }
        results.add(div);
    }
}
