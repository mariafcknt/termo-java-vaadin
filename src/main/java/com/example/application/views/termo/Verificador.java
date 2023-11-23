package com.example.application.views.termo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;

public class Verificador {
    private Palavra palavra;
    private boolean acerto;

    public Verificador() {
        this.palavra = new Palavra();
    }

    public Div verificarTentativa(String tentativa) {
        Div div = new Div();
        Div div_acerto = new Div();
        //String acerto;
        for (int i = 0; i < tentativa.length(); i++) {
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

            if (tentativa.equals(palavra.getPalavra())){
                setAcerto(true);
            }

        }
        System.out.println(palavra.getPalavra());
        return div;
    }

    public boolean isAcerto() {
        return acerto;
    }

    public void setAcerto(boolean acerto) {
        this.acerto = acerto;
    }
}