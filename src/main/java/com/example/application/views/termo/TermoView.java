package com.example.application.views.termo;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
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

    public TermoView() {

        setSpacing(false);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

        add(new H1("Termo"));

        Verificador verificador = new Verificador();
        results = new Div();

        // Input de tentativas
        TextField tentativa = new TextField();
        tentativa.setLabel("Adivinhe a palavra:");
        add(tentativa);

        // Criação e adição do botão
        Button button = new Button("Checar");
        button.addClickListener(buttonClickEvent -> {
            Div resultDiv = verificador.verificarTentativa(tentativa.getValue());
            results.add(resultDiv);
            add(results);
        });

        add(button);
        add(results);
    }
}
