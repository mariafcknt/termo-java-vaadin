package com.example.application.views.termo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;

public class Verificador {
    private Dicionario palavra;

    public Verificador() {
        this.palavra = new Dicionario();
    }

    public Div verificarTentativa(String tentativa) {
        System.out.println("Teste passoi por aq");
        Div div = new Div();
        int rodadas = 0;
        for (int i = 0; i < tentativa.length() && rodadas < 6 ; i++) {
            String letra = tentativa.substring(i, i + 1);
            Span badge = new Span(letra);
            if (letra.equals(palavra.getPalavra().substring(i, i + 1))) {
                badge.getElement().getThemeList().add("badge success");
            } else if (palavra.getPalavra().indexOf(letra) > -1) {
                badge.getElement().getThemeList().add("badge");
            } else {
                badge.getElement().getThemeList().add("badge contrast");
            }
            div.add(badge);
            rodadas += 1;
        }
       //results.add(div);
        System.out.println(div);

        return div;
    }
}
