/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import org.deeplearning4j.nn.api.Layer;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.LossLayer;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.multilayer.*;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.io.File;
import java.util.*;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.eval.RegressionEvaluation;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;

import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.io.ClassPathResource;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;

/**
 *
 * @author sameer
 */
public class NNModel {

    NNModel() {

    }

    //note to self: USE UPDATED DEPENDANCIES. 
    public double Dense(ArrayList<Double> grades) throws Exception {

        // LOADING THE MODEL from python
        MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights("regular");

        //MultiLayerNetwork model take an input of a a INDArray
        //so, I load 14 grades from the arrayList into an array
        double[] arr_1d = new double[14];
        for (int i = 0; i < grades.size(); i++) {
            arr_1d[i] = grades.get(i);
        }

        //then from an double[] array to an INDArray
        INDArray x = Nd4j.zeros(1, arr_1d.length);
        for (int i = 0; i < arr_1d.length; i++) {
            x.putScalar(0, i, arr_1d[i]);
        }

        //out will use the loaded model and the data in INDArray x to predict a value between 
        //1.07~.9
        INDArray output = model.output(x);
        
        //Rounding the decimal to two decimal places
        return Math.round(output.getDouble(0, 0)*100.0)/100.0;

    }

    public ArrayList<Double> Probability(ArrayList<Double> grades) throws Exception {
        
        //Loading the model from python
        MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights("prob");

        //MultiLayerNetwork model take an input of a a INDArray
        //so, I load 14 grades from the arrayList into an array
        double[] arr_1d = new double[14];
        for (int i = 0; i < grades.size(); i++) {
            arr_1d[i] = grades.get(i);
        }

        //then from an double[] array to an INDArray
        INDArray x = Nd4j.zeros(1, arr_1d.length);
        for (int i = 0; i < arr_1d.length; i++) {
            x.putScalar(0, i, arr_1d[i]);
        }
        
        //out will use the loaded model and the data in INDArray x to predict
        //7 probabilities. It will create a probability distribution
        INDArray output = model.output(x);
        
        //createing an arrayList to store each of the 7 probabilities
        ArrayList<Double> probs = new ArrayList<Double>();
        for (int i = 0; i < 7; i++) {
            //rounding each probability to two decimals
            double gg = Math.round(output.getDouble(0, i) * 100.0) / 100.0;
            probs.add(gg);
        }
        return probs;
    }

    public static void main(String[] args) throws Exception {

        NNModel n = new NNModel();
        ArrayList<Double> g = new ArrayList<Double>();
        double[] h = {7.9, 7.1, 7.8, 7.7, 6.8, 7.0, 7.0, 7.1, 7.2, 6.4, 6.4, 7.9, 7.0, 7.5};
        for (int i = 0; i < h.length; i++) {
            g.add(h[i]);
        }
        System.out.println(n.Dense(g));
        System.out.println(n.Probability(g));

    }

}
