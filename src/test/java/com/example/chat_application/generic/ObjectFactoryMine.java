package com.example.chat_application.generic;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

public class ObjectFactoryMine implements ObjectFactory {

  @Override
  public Object getObjectInstance(Object obj, Name name, Context nameCtx,
      Hashtable<?, ?> environment) throws Exception {
    return null;
  }
}
