package co.edu.umanizales.kid_kids.model;

import lombok.Data;

@Data
public class ListSE {
    private Node head;
    private int size;
    private int talla = 1;

    // Metodo para agregar
    public void add(Kid kid) {
        if (head == null) {
            head = new Node(kid);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(kid));
        }
        size++;
    }

    // Metodo para agregar a la cabeza
    public void addToStart(Kid kid) {
        if (head == null) {
            add(kid);
        } else {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    // Metodo para invertir la lista
    public String invert() {
        if (head == null) {
            return "No hay datos";
        }
        if(size == 1){
            return "Solo hay un dato";
        } else {
            if (size > 1) {
                ListSE listCp = new ListSE();
                Node temp = head;
                while (temp != null) {
                    listCp.addToStart(temp.getData());
                    temp = temp.getNext();
                }
                head = listCp.head;
            }
            return "Se invertio";
        }
    }

    // Metodo para agregar por posición
    public void addInPosition(Kid kid, int position) {
        if (head == null || position == 1 ) {
            addToStart(kid);
        }
        else {
            if (position > size) {
                add(kid);
            } else {
                int pos = 1;
                Node temp = head;
                while (pos < position - 1) {
                    temp = temp.getNext();
                    pos++;
                }
                // position before
                Node newNode = new Node(kid);
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
                size++;
            }
        }
    }

    // Metodo para borrar por posición
    public String deleteByPosition(int position) {
        if (position < 1 || position > getTalla()) {
        }
        if(size == 0){
            return "no  hay datos";
        }
        if (position == 1) {
            head = head.getNext();
        } else {
            Node temp = head;
            int pos = 1;

            while (pos < position - 1) {
                temp = temp.getNext();
                pos++;
            }

            temp.setNext(temp.getNext().getNext());
        }
        size--;
        return "Se borro";
    }

    // Metodo para borrar po id
    public String deleteById(String id) {
        if (head == null) {
            return "No hay datos";
        }
        if (head.getData().getId().equals(id)) {
            head = head.getNext();
            size--;
            return "Borrado exitosamente";
        } else {
            Node temp = head;

            while (temp.getNext() != null) {
                if (temp.getNext().getData().getId().equals(id)) {
                    temp.setNext(temp.getNext().getNext());
                    size--;

                    return "Borrado exitosamente";
                } 
                temp = temp.getNext();
            }
            return "No se encontró";
        }

    }

    public String changeExtrenes() {
        if (head == null) {
            return "No hay datos";
        }
        if(size == 1){
            return "Solo hay un dato";
        }
        else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            Kid Newkid = temp.getData();
            temp.setData(head.getData());
            head.setData(Newkid);
        }
        return "Se cambiaron los extremos";
    }


    public String mixByGender() {
        if (head == null) {
            return "No hay datos";
        }
        if(size == 1){
            return "Solo hay un genero";
        }
        if (size > 2) {
            int posB = 1;
            int posG = 2;

            ListSE listCp = new ListSE();
            Node temp = head;
            while (temp != null) {
                switch (temp.getData().getGender()) {
                    case 'F':
                    case 'f':
                        listCp.addInPosition(temp.getData(), posG);
                        posG += 2;
                        break;
                    default:
                        listCp.addInPosition(temp.getData(), posB);
                        posB += 2;
                }
                temp = temp.getNext();
            }
            this.head = listCp.getHead();
        }
        return "Se mezclo por genero";
    }

    //---------------------------------------------------------

    public String primeroMujer() {
        if (head == null) {
            return "No hay datos";
        } else {
            if (size >= 2) {
                Node temp = head;
                ListSE listCp = new ListSE();

                // Recorremos toda la lista
                while (temp != null) {
                    if (temp.getData().getGender() == 'F' || temp.getData().getGender() == 'f') {
                        // Si es mujer, la añadimos al inicio
                        listCp.addToStart(temp.getData());
                    }
                    temp = temp.getNext(); // Avanzar al siguiente nodo
                }
                this.head = listCp.getHead();
                // Aquí podrías devolver algo relacionado con listCp si fuera necesario
                return "Mujeres primero procesado";
            }
        }

        return "Hay datos";
    }

    public String menorMayor(){
        if (head == null) {
            return "No hay datos";
        } else {
            Node temp = head;
            // Puedes agregar lógica para encontrar el menor/mayor, o simplemente recorrer la lista.
            while (temp.getNext() != null) {
                if (temp.getData().getAge() < temp.getNext().getData().getAge()) {
                }
                temp = temp.getNext();
            }
            Kid Newkid = temp.getData();
            temp.setData(head.getData());
            head.setData(Newkid);
        }
        return "Hay dato";
    }


} // Fin de la clase ListSE
