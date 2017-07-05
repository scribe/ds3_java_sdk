package com.spectralogic.escapepod.persistence

import com.spectralogic.escapepod.api.PersistenceService
import jetbrains.exodus.entitystore.PersistentEntityStore

class XodusPersistenceService(entityStore: PersistentEntityStore) : PersistenceService
