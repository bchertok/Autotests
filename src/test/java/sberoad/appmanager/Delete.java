package sberoad.appmanager;

import java.util.List;

class Delete {
    String levelOne(String barcode) {
        // что это за сущность
        String entityType = DBArrays3random.selectEntityTypefromBARCODEinfo(barcode);

        if (entityType.equals("INVENTORY")) {
            return "INVENTORY_PID";
        }

        if (entityType.equals("DOCUMENT")) {
            // смотрим айди описи у этого документа
            String inventoryID = DBArrays2.ifDocumenthaveInventory(barcode);
            // смотрим включен ли документ в опись
            if (inventoryID != null) {
                // статус документов в этой описи
                List<String> documentInInventory = DBArrays2.documentStatewithINVENTORY(inventoryID);
                System.out.println("статус документов в описи" + documentInInventory);
                // Количество документов в описи
                System.out.println("kolvo docov v opisi " + documentInInventory.size());
                if (documentInInventory.size() >= 2) {
                    return "ничего не удаляем";
                } else {
                    String abs = DBArrays3random.ifInventorywasdowloadfromABS("INVENTORY", inventoryID);
                    System.out.println("FROM_ABS   " + abs);
                    if (abs.equals("1")) {
                        return "эта опись не должна быть удалена, выводим спец сообщение";
                    } else {
                        return "1";
                    }
                }
            }
            // документ не включен в опись
            else {
                return "DOCUMENT_PID";
            }
        }

        if (entityType.equals("DAILYBINDING")) {
            return "DAILYBINDING_PID";
        }

        return "NE TOT TIP SUSHNOSTY";
    }}
