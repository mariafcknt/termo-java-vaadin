package com.example.application.views.termo;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Termo")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class TermoView extends VerticalLayout {

    private final Div resultados;
    private TextField tentativa;
    private int rodada;
    private final Palavra palavra;

    public TermoView() {
        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

        add(new H1("Termo"));
        Div linhaVazia = new Div();
        linhaVazia.setHeight("20px");
        add(linhaVazia);

        palavra = new Palavra();
        Verificador verificador = new Verificador(palavra.getPalavra());
        resultados = new Div();

        HorizontalLayout inputLayout = new HorizontalLayout();
        inputLayout.setDefaultVerticalComponentAlignment(Alignment.END);

        tentativa = new TextField();
        tentativa.setLabel("Adivinhe a palavra:");
        inputLayout.add(tentativa);

        Button button = new Button("Checar");
        inputLayout.add(button);

        add(inputLayout);

        //Ver a palavra correta no console da IDE
        System.out.println("A palavra correta é " + getPalavra());

        tentativa.addKeyPressListener(Key.ENTER, event -> button.click());
        button.addClickListener(buttonClickEvent -> {
            Div resultDiv = verificador.verificarTentativa(tentativa.getValue());
            setRodada(rodada += 1);
            if (verificador.isAcerto()) {
                button.setVisible(false);
                button.setEnabled(false);
                Div div = new Div();
                Span badge = new Span(tentativa);
                badge.getElement().getThemeList().add("badge success");
                div.add(badge);
                resultados.add(resultDiv);
                add(resultados);
                add(linhaVazia);
                add(new H3("Parabéns, você acertou!"));
                Span paragrafo = new Span("Recarregue a página para jogar novamente!");
                add(paragrafo);
            } else if (getRodada() == 5) {
                button.setVisible(false);
                button.setEnabled(false);
                Div div = new Div();
                Span badge = new Span(tentativa);
                badge.getElement().getThemeList().add("badge contrast");
                div.add(badge);
                resultados.add(resultDiv);
                add(resultados);
                add(linhaVazia);
                add(new H3("Tentativas esgotadas, fim de jogo!"));
                Span paragrafo = new Span("A palavra correta era " + getPalavra() + " :( Recarregue a página para jogar novamente!");
                add(paragrafo);
            } else {
                resultados.add(resultDiv);
                add(resultados);
            }
            tentativa.clear();
        });
        add(inputLayout);
    }

    public String getPalavra() {
        return palavra.getPalavra();
    }

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }
}