package com.mariana.cesar6.Service;


import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;


import com.mariana.cesar6.Model.Node;


public class EmailService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public EmailService(String name) {
        super("EmailService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ResultReceiver receiver = intent.getParcelableExtra("MESSENGER");
        Node thread = (Node) intent.getExtras().get("NODE");

        Node header = sort(thread);
        Node node = header.getNext();
        Node ant = header;
        while (node != null) {
            if (node.getBody().equals(ant.getBody()) && node.getEmail().equals(ant.getEmail())) {
                ant.setNext(node.getNext());
                node.setNext(null);
            }
            node = node.getNext();
            ant = ant.getNext();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("result", header);
        receiver.send(1, bundle);
    }

    public Node sort(Node begin) {
        if (begin == null || begin.getNext() == null) {
            return begin;
        }
        Node nodeMidlle = findMidlle(begin);
        Node headerRight = nodeMidlle.getNext();
        nodeMidlle.setNext(null);
        Node nodeLeft = sort(begin);

        Node nodeRight = sort(headerRight);
        return mergeLists(nodeLeft, nodeRight);

    }

    public Node findMidlle(Node header) {
        Node nodeMidlle = header;
        header = header.getNext();
        while (header.getNext() != null) {
            header = header.getNext();
            if (header.getNext() != null) {
                header = header.getNext();

            }
            nodeMidlle = nodeMidlle.getNext();
        }
        return nodeMidlle;
    }

    public Node mergeLists(Node header1, Node header2) {
        Node aux;

        if (header1 == null) {
            return header2;
        }
        if (header2 == null) {
            return header1;
        }

        if (header1.getBody().compareTo(header2.getBody()) <= 0) {
            aux = header1;
            aux.setNext(mergeLists(header1.getNext(), header2));
        } else {
            aux = header2;
            aux.setNext(mergeLists(header1, header2.getNext()));
        }

        return aux;
    }
}
