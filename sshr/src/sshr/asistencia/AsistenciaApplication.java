package sshr.asistencia;import java.util.List;import sshr.asistencia.AsistenciaCrudService;import sshr.domainmodel.EntityFactory;import sshr.domainmodel.BaseEntity;import sshr.domainmodel.asistencia.GrupoHorario;public final class AsistenciaApplication {	private static AsistenciaCrudService _crudService;		static {		try {				_crudService = new AsistenciaCrudService();				} catch (Exception ex) { }	}		/*		SECTION: CRUD[GRUPO-HORARIO]			*/		public static GrupoHorario createGrupoHorario(String desc, String codigo) throws AsistenciaException {					try {					GrupoHorario gh = EntityFactory.getNewEntity(GrupoHorario.class);					gh.setDesc(desc);					gh.setCodigo(codigo);					gh = _crudService.add( gh );					if (gh == null) 						throw new AsistenciaException("No se pudo crear el Grupo de Horario.");										return gh;								} catch (Exception ex) { 									throw new AsistenciaException("An error has occurred, please review the log.", ex);			}		}			public static GrupoHorario updateGrupoHorario(Long id, String desc, String codigo) throws AsistenciaException {					try {					GrupoHorario gh = _crudService.find(GrupoHorario.class, id);					gh.setDesc(desc);					gh.setCodigo(codigo);										gh = _crudService.update( gh );					if (gh == null) 						throw new AsistenciaException("No se pudo actualizar el Grupo de Horario.");																	return gh;								} catch (Exception ex) { 									throw new AsistenciaException("An error has occurred, please review the log.", ex);			}		}		public static List<GrupoHorario> findAllGrupoHorario() throws AsistenciaException {					try {					return _crudService.findAll(GrupoHorario.class);								} catch (Exception ex) { System.out.println("************************************************");			ex.printStackTrace();						throw new AsistenciaException("An error has occurred, please review the log.", ex);			}		}		public static GrupoHorario findGrupoHorario(Long id) throws AsistenciaException {					try {					return _crudService.find(GrupoHorario.class, id);								} catch (Exception ex) { 									throw new AsistenciaException("An error has occurred, please review the log.", ex);			}		}		public static void removeGrupoHorario(GrupoHorario gh) throws AsistenciaException {					try {					_crudService.remove(gh);								} catch (Exception ex) { 									throw new AsistenciaException("An error has occurred, please review the log.", ex);			}		}}