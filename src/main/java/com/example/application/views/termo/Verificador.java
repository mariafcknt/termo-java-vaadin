package com.example.application.views.termo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;

public class Verificador {
    private String palavra;
    private boolean acerto;

    public Verificador(String palavra) {
        this.palavra = palavra;
        setPalavra(palavra);
    }

    public Div verificarTentativa(String tentativa) {
        Div div = new Div();
        for (int i = 0; i < tentativa.length(); i++) {
            String letra = tentativa.substring(i, i + 1);
            Span badge = new Span(letra);
            if (letra.equals(getPalavra().substring(i, i + 1))) {
                badge.getElement().getThemeList().add("badge success");
            } else if (getPalavra().contains(letra)) {
                badge.getElement().getThemeList().add("badge");
            } else {
                badge.getElement().getThemeList().add("badge contrast");
            }
            div.add(badge);
            if (tentativa.equals(getPalavra())){
                setAcerto(true);
            }
        }
        return div;
    }

    public boolean isAcerto() {
        return acerto;
    }

    public void setAcerto(boolean acerto) {
        this.acerto = acerto;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}