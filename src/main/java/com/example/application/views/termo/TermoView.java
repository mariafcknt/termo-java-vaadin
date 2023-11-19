package com.example.application.views.termo;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
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
    //private String word;

    public TermoView() {

        setSpacing(false);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

        add(new H1("Termo"));



        // Input de tentativas
        TextField guessInput = new TextField();
        guessInput.setLabel("Adivinhe a palavra:");
        add(guessInput);

        // Criação e adição do botão
        Button button = new Button("Checar");
        button.addClickListener(buttonClickEvent -> checkGuess(guessInput.getValue()));
        add(button);

        Div results = new Div();
        add(results);
    }

    private void checkGuess(String guess) {
        Div div = new Div();
        String output = "";
        String word = "bunny";
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
        results.add(output);

        //teste
    }
}
