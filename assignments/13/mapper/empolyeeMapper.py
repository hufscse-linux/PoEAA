from abstractMapper import abstractMapper
from domain.team import Team
from teamMapper import TeamMapper
from domain.project import Project
from projectMapper import ProjectMapper
from domain.position import Position
from positionMapper import PositionMapper
from domain.empolyee import Empolyee

class EmpolyeeMapper(abstractMapper):

    def __init__(self):
        super(EmpolyeeMapper, self).__init__()
        self.COLUMNS = 'En, Name, TeamId, ProjectId, PositionId'

    def findStatement(self):
        return "SELECT %s FROM EMPOLYEE where En = ? "%self.COLUMNS

    def find(self, domain_id):
        return self.abstractFind(domain_id)

    def doLoad(self, domain_id, rs):
        projectMapper = ProjectMapper()
        teamMapper = TeamMapper()
        positionMapper = PositionMapper()
        name = rs[1]
        team = teamMapper.find(rs[2])
        project = projectMapper.find(rs[3])
        position = positionMapper.find(rs[4])
        return Empolyee(name, domain_id, team, project, position)

