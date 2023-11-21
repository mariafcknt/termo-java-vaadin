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
    private String word = "bunny";
    private TextField tentativa;
    //private  TextField tentativa;
    //private String word;

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

        //checkGuess(tentativa);
        //verificador.verificarTentativa(tentativa.getValue());
        add(results);
    }

   /* private void checkGuess(String guess) {
        Div div = new Div();
        //String output = "";

        for (int i = 0; i < guess.length(); i++) {
            String letter = guess.substring(i, i+1);
            Span badge = new Span(letter);
            if (letter.equals(word.substring(i, i+1))) {
              //  output += letter;
                badge.getElement().getThemeList().add("badge success");
            } else if (word.indexOf(letter) > -1){
                //output += "+";
                badge.getElement().getThemeList().add("badge");
            } else {
                //output += "*";
                badge.getElement().getThemeList().add("badge contrast");
            }
            div.add(badge);
        }
        results.add(div);
        //System.out.println(results);
        //add(new H1(results));
        //System.out.println(results.add(div));

        //teste
    }*/
}
