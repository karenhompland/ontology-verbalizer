package com.ontology.verbalizer.utils.sesotho;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontology.verbalizer.utils.WordAndSentenceCleaner;

@Component
public class SesothoSentenceVerbalizerImpl implements SesothoSentenceVerbalizer {

    @Autowired
    WordAndSentenceCleaner WordAndSentenceCleaner;

    @Override
    public String verbalizeSesothoSubclassAxiom(String subclassVerbalization, String superclassVerbalization) {
        String sentence = subclassVerbalization + " ke " + superclassVerbalization;
        return sentence;
    }

    @Override
    public String verbalizeSesothoUnionAxiom(String unionClassVerbalization,
            List<String> disjointClassesVerbalization) {
        String sentence = unionClassVerbalization + " ke " + String.join(" le ", disjointClassesVerbalization);
        return sentence;
    }

    @Override
    public String verbalizeSesothoDisjointClassesAxiom(List<String> classExpressions) {
        String sentence = WordAndSentenceCleaner.listToSentence(classExpressions, "'and' (change to SeSotho)") +
                " 'is not the same' (change to Sesotho)";
        return WordAndSentenceCleaner.cleanUpSentence(sentence);
    }

    @Override
    public String verbalizeSesothoClassExpression(String fillerName, String propertyName) {
        String sentence = fillerName + " e na le " + propertyName;
        return sentence;
    }

    @Override
    public String verbalizeSesothoIrrefObjProp(List<String> property) {
        return WordAndSentenceCleaner.cleanUpSentence("'" + WordAndSentenceCleaner.splitObjProp(property.get(0)) + "'"
                + " is a xx object property (in SeSotho :))");
    }

    @Override
    public String verbalizeSesothoAsymObjProp(List<String> property) {
        return WordAndSentenceCleaner.cleanUpSentence("'" + WordAndSentenceCleaner.splitObjProp(property.get(0)) + "'"
                + " is a xx object property (in SeSotho :))");
    }

    @Override
    public String verbalizeSesothoSymObjProp(List<String> property) {
        return WordAndSentenceCleaner.cleanUpSentence("'" + WordAndSentenceCleaner.splitObjProp(property.get(0)) + "'"
                + " is a xx object property (in SeSotho :))");
    }

    @Override
    public String verbalizeSesothoTransObjProp(List<String> property) {
        return WordAndSentenceCleaner.cleanUpSentence("'" + WordAndSentenceCleaner.splitObjProp(property.get(0)) + "'"
                + " is a xx object property (in SeSotho :))");
    }

    @Override
    public String verbalizeSesothoInverseObjProp(List<String> property) {
        return WordAndSentenceCleaner.cleanUpSentence("'" + WordAndSentenceCleaner.splitObjProp(property.get(0)) + "'"
                + " is a xx object property (in SeSotho :))");
    }

    @Override
    public String verbalizeSesothoFuncObjProp(List<String> property) {
        return WordAndSentenceCleaner.cleanUpSentence("'" + WordAndSentenceCleaner.splitObjProp(property.get(0)) + "'"
                + " is a xx object property (in SeSotho :))");
    }

    @Override
    public String verbalizeSesothoRefObjProp(List<String> property) {
        return WordAndSentenceCleaner.cleanUpSentence("'" + WordAndSentenceCleaner.splitObjProp(property.get(0)) + "'"
                + " is a xx object property (in SeSotho :))");
    }

    @Override
    public String verbalizeSesothoSubPropAxiom(String subProperty, String superProperty) {
        String sentence = "'" + WordAndSentenceCleaner.splitObjProp(subProperty) + "' 'is a sub relation of' (SeSotho) "
                + "'"
                + WordAndSentenceCleaner.splitObjProp(superProperty) + "'";
        return WordAndSentenceCleaner.cleanUpSentence(sentence);
    }

    @Override
    public String verbalizeObjectPropRangeAx(String property, String range) {
        return WordAndSentenceCleaner.cleanUpSentence("'" + WordAndSentenceCleaner.splitObjProp(property) + "'"
                + " 'has this range (SeSotho): ' " + WordAndSentenceCleaner.splitObjProp(range));
    }

    @Override
    public String verbalizeSesothoInversePropAx(List<String> property) {
        return WordAndSentenceCleaner.cleanUpSentence("'" + WordAndSentenceCleaner.splitObjProp(property.get(0)) + "'"
                + " Is the opposite of (in SeSotho :)) " + "'"
                + WordAndSentenceCleaner.splitObjProp(property.get(1) + "'"));
    }

    public String verbalizeEquivalentClassesAxiom(List<String> classExpressions) {
        String sentence = classExpressions.stream()
                .map(n -> String.valueOf(n))
                .skip(1)
                .limit(classExpressions.size() - 1)
                .collect(Collectors.joining(", "));
        sentence = classExpressions.get(0) + " 'is defined by:' (SeSotho) " + sentence + " 'and' (SeSotho) " +
                classExpressions.get(classExpressions.size() - 1);
        return WordAndSentenceCleaner.cleanUpSentence(sentence);
    }


    @Override
    public String verbalizeSesothoForAllExpression(String fillerName, String propertyName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verbalizeSesothoForAllExpression'");
    }

    @Override
    public String verbalizeSesothoUnionOf(ArrayList<String> classesInUnion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verbalizeSesothoUnionOf'");
    }

    @Override
    public String verbalizeSesothoIntersectionOf(ArrayList<String> classesInIntersection) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verbalizeSesothoIntersectionOf'");
    }

    @Override
    public String verbalizeSesothoComplementOf(String className) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verbalizeSesothoComplementOf'");
    }
}
