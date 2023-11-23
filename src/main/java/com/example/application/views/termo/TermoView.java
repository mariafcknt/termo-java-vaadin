package com.example.application.views.termo;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
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
public class TermoView extends VerticalLayout{

    private Div results;
    //private String word = "bunny";
    private TextField tentativa;
    private int rodada;

    public TermoView() {

        setSpacing(false);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

        add(new H1("Termo"));

        Verificador verificador = new Verificador();
        results = new Div();

        TextField tentativa = new TextField();
        tentativa.setLabel("Adivinhe a palavra:");
        add(tentativa);

        Button button = new Button("Checar");

        button.addClickListener(buttonClickEvent -> {
            Div resultDiv = verificador.verificarTentativa(tentativa.getValue());
            if (verificador.isAcerto()) {
                    Div div = new Div();
                    Span badge = new Span(tentativa);
                    badge.getElement().getThemeList().add("badge success");
                    div.add(badge);
                    results.add(resultDiv);
                    add(results);
                    add(new H3("Parabéns, você acertou!"));
                    button.setEnabled(false);
            } else if (getRodada() == 5){
                    add(new H3("Tentativas esgotadas, fim de jogo!"));
                    Span paragrafo = new Span("A palavra correta era " + verificador.getPalavra());
                    add(paragrafo);

                    button.setEnabled(false);
            } else {
                    results.add(resultDiv);
                    add(results);
            }
            setRodada(rodada += 1);
        });
        add(button);
        add(results);
    }

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }
}


