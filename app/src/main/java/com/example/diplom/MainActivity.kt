package com.example.diplom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.semanticweb.owlapi.model.OWLOntologyManager
import java.io.File
import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.OWLOntology
import org.semanticweb.owlapi.model.IRI

import org.semanticweb.owlapi.model.OWLOntologyStorageException

import org.semanticweb.owlapi.model.OWLOntologyCreationException
import java.lang.Exception


var owlManager = OWLManager.createOWLOntologyManager()
var owlURI = "http://www.owl-ontologies.com/family.owl#"

// ontology URI
var owlFileURI = "C:\\Users\\bykov\\IdeaProjects\\LABA1\\Lab1_new.owl"

// ontology file
var owlFile: File = File(owlFileURI)
var ontologyManager: OWLOntologyManager? = null
var filename = "Family_orig_new_kotl.owl"
var newOntFile = File("C:\\Users\\bykov\\AndroidStudioProjects\\DIPLOM2\\$filename")
var ontology: OWLOntology? = null
var OWLIRI = "http://www.owl-ontologies.com/family.owl#"

//val ont: OWLOntology = owlManager.loadOntologyFromOntologyDocument(owlFile)

class MainActivity : AppCompatActivity() {

    var owlManager = OWLManager.createOWLOntologyManager()
    @Throws(OWLOntologyCreationException::class, OWLOntologyStorageException::class)
    fun CreateOntology() {
        //PrefixManager pm = new DefaultPrefixManager(OWLIRI);
        ontology = owlManager.createOntology(IRI.create("http://www.owl-ontologies.com/family.owl"))
        //File newOntFile = new File("C:\\Users\\bykov\\IdeaProjects\\LABA1\\" + filename);
        owlManager.saveOntology(ontology!!, IRI.create(newOntFile.toURI()))
    }

    fun saveOntology() {
        try {
            println("Saving the ontology...")
            ontology?.let { owlManager.saveOntology(it, IRI.create(newOntFile)) }
        } catch (e: Exception) {
            println("ERROR in saving ontology!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //val ont: OWLOntology = owlManager.loadOntologyFromOntologyDocument(owlFile)
}